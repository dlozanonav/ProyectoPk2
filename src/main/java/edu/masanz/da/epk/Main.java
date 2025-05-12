package edu.masanz.da.epk;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinFreemarker;

import edu.masanz.controller.EditorController;
import org.eclipse.jetty.server.session.DefaultSessionCache;
import org.eclipse.jetty.server.session.FileSessionDataStore;
import org.eclipse.jetty.server.session.SessionCache;
import org.eclipse.jetty.server.session.SessionHandler;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        Javalin app1 = Javalin.create(config -> {
            config.jetty.modifyServletContextHandler(handler -> handler.setSessionHandler(fileSessionHandler("session1")));
            config.staticFiles.add("/public");
            config.fileRenderer(new JavalinFreemarker());
        }).start(4444);

        setJavalinAppRoutes(app1);

    }

    private static void setJavalinAppRoutes(Javalin app) {
        app.get("/",EditorController::iniciar);

    }

    public static SessionHandler fileSessionHandler(String sessionName) {
        SessionHandler sessionHandler = new SessionHandler();
        SessionCache sessionCache = new DefaultSessionCache(sessionHandler);
        sessionCache.setSessionDataStore(fileSessionDataStore());
        sessionHandler.setSessionCache(sessionCache);
        sessionHandler.setHttpOnly(true);
        // make additional changes to your SessionHandler here
        sessionHandler.setSessionCookie(sessionName);// YO
        return sessionHandler;
    }
    private static FileSessionDataStore fileSessionDataStore() {
        FileSessionDataStore fileSessionDataStore = new FileSessionDataStore();
        File baseDir = new File(System.getProperty("java.io.tmpdir"));
        File storeDir = new File(baseDir, "javalin-session-store");
        //C:\Users\USUARIO\AppData\Local\Temp\javalin-session-store
        storeDir.mkdir();
        fileSessionDataStore.setStoreDir(storeDir);
        return fileSessionDataStore;
    }

}