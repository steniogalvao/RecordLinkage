package br.com.vsg.recordlinkage.services;

import java.util.List;

import br.com.vsg.recordlinkage.entities.Link;

public interface LinkService {

	public Link loadLink(Link link);

	public void saveLink(Link link);

	public void deleteLink(Link link);

	public List<Link> findAllLink();

}
