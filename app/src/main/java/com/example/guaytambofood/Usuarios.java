package com.example.guaytambofood;

public class Usuarios
{
    private int _id;
    public int getid()
    {
        return this._id;
    }
    public void setid(int value)
    {
        this._id = value;
    }

    private String _usuario;
    public String getusuario()
    {
        return this._usuario;
    }
    public void setusuario(String value)
    {
        this._usuario = value;
    }

    private String _contrasenia;
    public String getcontrasenia()
    {
        return this._contrasenia;
    }
    public void setcontrasenia(String value)
    {
        this._contrasenia = value;
    }

    private String _nombre;
    public String getnombre()
    {
        return this._nombre;
    }
    public void setnombre(String value)
    {
        this._nombre = value;
    }

    private String _apellido;
    public String getapellido()
    {
        return this._apellido;
    }
    public void setapellido(String value)
    {
        this._apellido = value;
    }

    private String _perfilUsuario;
    public String getperfilUsuario()
    {
        return this._perfilUsuario;
    }
    public void setperfilUsuario(String value)
    {
        this._perfilUsuario = value;
    }

    private String _email;
    public String getemail()
    {
        return this._email;
    }
    public void setemail(String value)
    {
        this._email = value;
    }

    private byte[] _fotoPerfil;
    public byte[] getfotoPerfil()
    {
        return this._fotoPerfil;
    }
    public void setfotoPerfil(byte[] value)
    {
        this._fotoPerfil = value;
    }


    public Usuarios(int id_,String usuario_,String contrasenia_,String nombre_,String apellido_,String perfilUsuario_,String email_,byte[] fotoPerfil_)
    {
        this._id= id_;
        this._usuario = usuario_;
        this._contrasenia = contrasenia_;
        this._nombre = nombre_;
        this._apellido = apellido_;
        this._perfilUsuario = perfilUsuario_;
        this._email = email_;
        this._fotoPerfil = fotoPerfil_;
    }
}
