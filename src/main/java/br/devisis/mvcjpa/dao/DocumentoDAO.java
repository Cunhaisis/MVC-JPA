package br.devisis.mvcjpa.dao;

import br.devisis.mvcjpa.entity.Documento;

public class DocumentoDAO extends GenericDAO<Documento> {

     public DocumentoDAO(){
         super(Documento.class);
     }
}
