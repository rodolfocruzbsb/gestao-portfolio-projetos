package br.com.rscruz.springmvc.model;

import java.io.Serializable;

/**
 * <p>
 * <b>Title:</b> Entidade.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Interface para representar uma entidade
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * @param <ID>
 * 
 * @version 1.0.0
 */
public interface Entidade<ID extends Serializable> extends Serializable {

	ID getId();

	void setId(ID id);

}
