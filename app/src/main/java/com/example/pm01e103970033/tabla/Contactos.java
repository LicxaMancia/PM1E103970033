package com.example.pm01e103970033.tabla;

public class Contactos {
        public Integer id;
        public String nombres;
        public String nota;
        public Integer telefono;
        public String pais;

        // Constructor de clase
        public Contactos()
        {
            //Todo
        }

        public Contactos(Integer id, String nombres, String nota, Integer telefono, String pais) {
            this.id = id;
            this.nombres = nombres;
            this.nota = nota;
            this.telefono = telefono;
            this.pais = pais;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public String getnota() {
            return nota;
        }

        public void setnota(String nota) {
            this.nota = nota;
        }

        public Integer gettelefono() {
            return telefono;
        }

        public void settelefono(Integer telefono) {
            this.telefono = telefono;
        }

        public String getpais() {
            return pais;
        }

        public void setpais(String pais) {
            this.pais = pais;
        }
    }

