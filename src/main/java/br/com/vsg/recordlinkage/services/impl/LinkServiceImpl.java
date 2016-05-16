package br.com.vsg.recordlinkage.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vsg.recordlinkage.dao.LinkDAO;
import br.com.vsg.recordlinkage.entities.Link;
import br.com.vsg.recordlinkage.services.LinkService;

@Service("linkService")
@Transactional
public class LinkServiceImpl implements LinkService {

	@Autowired
	private LinkDAO dao;

	public Link loadLink(Link link) {
		return dao.load(link);
	}

	public void saveLink(Link link) {
		dao.save(link);
	}

	public List<Link> findAllLink() {
		return dao.findAllLink();
	}

	public void deleteLink(Link link) {
		dao.deleteLink(link);
	}

}