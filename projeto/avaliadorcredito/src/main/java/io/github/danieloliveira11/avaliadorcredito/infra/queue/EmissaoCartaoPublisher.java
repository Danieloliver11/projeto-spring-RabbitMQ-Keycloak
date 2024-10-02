package io.github.danieloliveira11.avaliadorcredito.infra.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.danieloliveira11.avaliadorcredito.model.queue.SolicitacaoEmissaoCartaoVO;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmissaoCartaoPublisher {
	
	private final RabbitTemplate rabbiteTemplate;
	private final Queue filaCartoes;
	
	public void solicitarCartao(SolicitacaoEmissaoCartaoVO emissaoCartao) throws JsonProcessingException {
		
		String cartoesJson = converterParaJson(emissaoCartao);
		
		rabbiteTemplate.convertAndSend(filaCartoes.getName(), cartoesJson);
		
	}
	
	private String converterParaJson(SolicitacaoEmissaoCartaoVO emissaoCartao) throws JsonProcessingException {
		ObjectMapper mapper =  new ObjectMapper();
		return mapper.writeValueAsString(emissaoCartao);
	}

}
