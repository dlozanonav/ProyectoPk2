package edu.masanz.dto;

public class MapaDTO {
    private long id;
    private int orden;
    private String nombre;

    public MapaDTO() {
        this(0,0,"");
    }

    public MapaDTO(long id, int orden, String nombre) {
        this.id = id;
        this.orden = orden;
        this.nombre = nombre;
    }

    public String toJson(){
        return "{\"id\":"+id+",\"orden\":"+orden+",\"nombre\":\""+nombre+"\"}";
    }

}

