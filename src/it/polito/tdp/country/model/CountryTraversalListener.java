package it.polito.tdp.country.model;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.event.ConnectedComponentTraversalEvent;
import org.jgrapht.event.EdgeTraversalEvent;
import org.jgrapht.event.TraversalListener;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.graph.DefaultEdge;

public class CountryTraversalListener implements TraversalListener<Country, DefaultEdge> {

	private Graph<Country, DefaultEdge> graph;
	private Map<Country, Country> map;
	
	public CountryTraversalListener(UndirectedGraph<Country, DefaultEdge> g, Map<Country, Country> albero) {
		this.graph = g;
		this.map = albero;
	}
	@Override
	public void connectedComponentFinished(ConnectedComponentTraversalEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectedComponentStarted(ConnectedComponentTraversalEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edgeTraversed(EdgeTraversalEvent<DefaultEdge> evento) {
		//evento.getEdge(); //è l'arco attraversato
		//dall'edge devo estrarre source e destination
		//aggiungo in una mappa il link tra i due
		Country c1 = graph.getEdgeSource(evento.getEdge());
		Country c2 =  graph.getEdgeTarget(evento.getEdge());
		//se ho un arco tra due nodi che già conosco (e ho gia nella mappa) allora non devo fare niente
		if(map.containsKey(c1) && map.containsKey(c2))
			return;
		if(!map.containsKey(c1))
				map.put(c1,c2);//c1 è quello nuovo
		else
			map.put(c2,c1 );
		
	}

	@Override
	public void vertexFinished(VertexTraversalEvent<Country> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vertexTraversed(VertexTraversalEvent<Country> arg0) {
		// TODO Auto-generated method stub
		
	}

}
