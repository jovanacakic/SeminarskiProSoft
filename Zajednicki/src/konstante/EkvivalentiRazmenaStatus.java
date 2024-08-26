/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package konstante;

/**
 *
 * @author jovana
 */
public enum EkvivalentiRazmenaStatus {
    NEW, // Objekat koji treba da se ubaci u bazu
    UPDATED, // Objekat koji je izmenjen i treba da se ažurira u bazi
    DELETED, // Objekat koji treba da se obriše iz baze
    UNCHANGED // Objekat koji nije promenjen i ne zahteva akciju
}
