package com.example.consumirApi.service;

import com.example.consumirApi.Repository.FeriadoRepository;
import com.example.consumirApi.model.Feriado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FeriadoService {
    @Autowired
    private FeriadoRepository feriadoRepository;

    RestTemplate restTemplate= new RestTemplate();

    public void save(){

        ResponseEntity<Feriado[]> response =
                restTemplate.getForEntity(
                        "https://feriados-cl-api.herokuapp.com/feriados",
                        Feriado[].class);
        Feriado[] feriados = response.getBody();
        for (Feriado feriado: feriados
             ) {
            Feriado fe = new Feriado();
            fe.setDate(feriado.getDate());
            fe.setTitle(feriado.getTitle());
            fe.setExtra(feriado.getExtra());
            feriadoRepository.save(fe);
            System.out.println(feriado.getDate());
        }


    }
}
