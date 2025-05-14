package br.unipar.programacaoweb.livraria.configuration;

import br.unipar.programacaoweb.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulerConfig {

    @Autowired
    private LivroService livroService;

    @Scheduled(fixedRate = 5000)
    public void scheduleTask() {
        System.out.println("Tarefa executada agora!");
        livroService.criarNovaLeituraAleatoria();
    }

    @Scheduled(fixedRate = 5000)
    public void sensorInativaAleatoriamente() {
        System.out.println("Sensor Inativado agora!");
        //inativer um sensor aleatoriamente
    }


    @Scheduled(fixedRate = 20000)
    public void verificarSensoresInativos() {
        // Verifica se algum sensor está inativo
        livroService.verificarSensoresOffline();
    }
}
