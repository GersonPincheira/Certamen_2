package ejemplo.certamen2.Models;

/**
 * Created by gerson on 30-09-16.
 */

public class DatosGit {
    private String titulo;
    private String descripcion;
    private String actualizacion;
    private String URL;
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    public void setActualizacion(String actualizacion){
        this.actualizacion=actualizacion;
    }
    public void setUrl(String URL){
        this.URL=URL;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public String getActualizacion(){
        return this.actualizacion;
    }
    public String getUrl(){
        return this.URL;
    }
}
