package br.com.alura.forum.controller.dto;

import br.com.alura.forum.model.StatusTopico;
import br.com.alura.forum.model.Topico;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetalhesTopicoDto {
	
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime data;
	private String nomeAutor;
	private StatusTopico status;
	private List<RespostaDto> respostas;
	
	public DetalhesTopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.data = topico.getDataCriacao();
		this.nomeAutor = topico.getAutor().getNome();
		this.status = topico.getStatus();
		
		this.respostas = new ArrayList<>();
		this.respostas.addAll(topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList()));
	}
	
	public static List<DetalhesTopicoDto> converter(List<Topico> topicos) {
		return topicos.stream().map(DetalhesTopicoDto::new).collect(Collectors.toList());
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	
	public String getNomeAutor() {
		return nomeAutor;
	}
	
	public StatusTopico getStatus() {
		return status;
	}
	
	public List<RespostaDto> getRespostas() {
		return respostas;
	}
	
}
