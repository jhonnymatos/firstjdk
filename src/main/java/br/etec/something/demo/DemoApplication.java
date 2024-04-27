package br.etec.something.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
    public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }

	@GetMapping("/aluno")
    public String aluno(@RequestParam(value = "ra", defaultValue = "0") int ra) {
		if (ra <= 0) {
			if (ra == 2500 || ra == 2 || ra == 22155){
				return String.format("<span style=\"color:black; font-size:15px;\">aluno %d!</span>", ra);
			} else {
				return String.format("<span style=\"color:black; font-size:15px;\">Aluno %d sem registro<span>", ra);
			}
		} else{
			return String.format("<span style=\"color:black; font-size:15px;\">RA: %d. Não Permitido!<span>", ra);
		}
    }

	@GetMapping("/**")
	public String fallback() {
		return String.format("<span style=\"color:black; font-size:15px;\">404 Página não encontrada!</span>");
	}
}
