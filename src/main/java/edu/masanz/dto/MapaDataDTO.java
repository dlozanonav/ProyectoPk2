package edu.masanz.dto;

public class MapaDataDTO extends MapaDTO {
    private static final int FILAS = 40;
    private static final int COLUMNAS = 30;

    private static final int TIERRA=0;
    private static final int PARED=4;


    private String surfaces;
    private String elements;

    public MapaDataDTO() {
        super();
        this.surfaces = initData();
        this.elements = initData();
    }

    private String initData() {

        //4 4 4
        //4 0 4
        //4 0 4
        //4 4 4

        StringBuilder superficieMapa = new StringBuilder();
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (i==0 || i==FILAS-1 || j==0 || j==COLUMNAS-1) {
                    superficieMapa.append(PARED).append(' ');
                } else {
                    superficieMapa.append(TIERRA).append(' ');
                }
                superficieMapa.append('\n');
            }
        }
        return superficieMapa.toString();
    }

    public String toArray(String matriz){
        //aqui pasamos el mapa a un formato array para luego que la plantilla entienda los elementos que se encuentran en el mapa
        //'4', '4', '4' , '4' , '4', '0' ,

        StringBuilder sb = new StringBuilder();

        String[] a = matriz.split("\\s+"); //Con \\s+ podemos hacer split con todos los string o caracteres que estan separados, hace split en los espacios, el +e es para q lo haga contodo

        for (String s : a) {

            sb.append("'").append(s).append("',");
        }
             sb.deleteCharAt(sb.length()-1); //borramos los dos espacios porq esta el espacio de salto de linea

             sb.deleteCharAt(sb.length()-1); // borramos la comilla tambien

        return sb.toString();
    }

    public MapaDataDTO(long id, int orden,
                       String nombre, String surfaces, String elements) {
        super(id, orden, nombre);
        this.surfaces = surfaces;
        this.elements = elements;

    }

    public void setSurfaces(String surfaces) {

        this.surfaces = surfaces;
    }
    public void setElements(String elements) {

        this.elements = elements;
    }

    public String getSurfaces() {

        return toArray(surfaces);
    }

    public String getElements() {

        return toArray(elements);
    }

    public static void main(String[] args) {
        MapaDataDTO dto = new MapaDataDTO();
        System.out.println(dto.getSurfaces());
        System.out.println(dto.getElements());
        System.out.println("-".repeat(80));

    }
}
