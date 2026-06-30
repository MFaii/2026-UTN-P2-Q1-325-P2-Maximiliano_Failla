/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecadigitalparcial;

import java.util.Objects;

/**
 *
 * @author Maxi
 */
public class Socio extends Persona {

    private String dni;
    private String email;

    public Socio(String dni, String nombre, String apellido, String email) {
        super(nombre, apellido);
        this.dni = dni;
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Socio other = (Socio) obj;
        return dni.equals(other.dni);
    }

    @Override
    public String toString() {
        return "Socio{"
                + "dni='" + getDni() + '\''
                + ", nombre='" + getNombre() + '\''
                + ", apellido='" + getApellido() + '\''
                + ", email='" + getEmail() + '\''
                + '}';
    }

}
