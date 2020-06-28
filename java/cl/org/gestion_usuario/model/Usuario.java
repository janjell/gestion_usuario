package cl.org.gestion_usuario.model;

public class Usuario {
    private String nombre;
    private String apellido;
    private String run;
    private int edad;
    private String sexo;
    private String genero_jf;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String run, int edad, String sexo, String genero_jf) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.run = run;
        this.edad = edad;
        this.sexo = sexo;
        this.genero_jf = genero_jf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGenero_jf() {
        return genero_jf;
    }

    public void setGenero_jf(String genero_jf) {
        this.genero_jf = genero_jf;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre +"\n"+ "Apellido: "+apellido +"\n"+"Edad: "+edad +"\n"+ "Genero de Juego Favorito:" +genero_jf +"\n";
    }
}
