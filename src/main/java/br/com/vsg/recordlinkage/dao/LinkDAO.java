package br.com.vsg.recordlinkage.dao;

import java.util.List;

import br.com.vsg.recordlinkage.entities.Link;

public interface LinkDAO {

	public Link load(Link link);

	public void save(Link link);

	public void deleteLink(Link link);

	public List<Link> findAllLink();

}
