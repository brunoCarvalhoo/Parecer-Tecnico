## Aplicação para Preenchimento de Parecer Técnico
Projeto Proposto no Módulo de Experiência Prática do NExT 2022.2 da Cesar School
***
### Objetivo:
Almeja-se criar um sistema que consiga preencher dados em dado formato de um template de documento e
, posteriormente, exporta-lo no formato excel **(.xlsx)**
***

### Sobre:
O projeto começou com uma _Prova de Conceito_. Onde foram realizados diversos testes
onde buscou-se verificar se a tecnologia escolhida permite fazer tudo o que foi proposto.
Entre eles:
*   Realizar Download de arquivo .xlsx no JAVA;
*   Realizar uma comunicação com o Banco de Dados e Interagir com ele.

Simultâneamente, traçou-se um modelo de entidade e relacionamento do sistema(ORM)
para que as entradas de dados e seus relacionamentos fossem mapeados. Afim de , posteriormente,
implementar-los no SQL.

> PS: Nesta etapa definiu-se quais valores seriam pré-definidos.Neste projeto foram: Aparelho, Defeito e Técnico.

Segundo o modelo de relacionamento foram criadas classes de _Entidade_(Cada tabela no SQL tem um modelo de entidade relacionado no JAVA).
As entidades relacionam-se entre si conforme descrito no ORM através das marcações.

> (@OneToOne,@OneToMany,@ManyToMany,...).

```Java
@Entity
public class Parecer {
	
	@Id
	private long id;
	private String parecer;
	
	@ManyToOne
	@JoinColumn(name = "id_defeito")
	private Defeito defeito;
	@ManyToOne
	@JoinColumn(name = "id_equipamento")
	private Equipamento equipamento;
	@ManyToOne
	@JoinColumn(name = "id_tecnico")
	private Tecnico tecnico;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
```

Após a criação das entidades. Foram implementadas 3 das 4 operações básicas utilizadas em bases de dados relacionais.
*   Adicionar
*   Ler
*   Deletar

Estas operações foram feitas utilizando o RESTController.
```Java
@RestController
@RequestMapping(value = "/Parecer")
public class ParecerController {
	
	@Autowired
	private ParecerRepository repository;
	
	@GetMapping
	public List<Parecer> findAll(){
		List<Parecer> result = repository.findAll();
		return result;
	}
	
	@GetMapping (value = "/{id}")
	public Parecer findById(@PathVariable Long id){
		Parecer result = repository.findById(id).get();
		return result;
	}
	
	@PostMapping
	public Parecer insert(@RequestBody Parecer parecer){
		Parecer result = repository.save(parecer);
		return result;
	}
	
	@DeleteMapping (value = "/{id}")
	public void delete(@PathVariable Long id){
		repository.deleteById(id);
	}
```
Uma vez que tanto os Controladores quanto os Repositórios estavam propriamente funcionando. Desenvolveu-se a etapa final do Projeto a exportação para o excel. O relacionamento foi desenvolvido em uma classe própria e, posteriormente, adicionada ao _ParecerController_

```Java
@GetMapping(value = "/excel")
	public void ExportarParaExcel(HttpServletResponse retorno) throws IOException{
		retorno.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Parecer_info.xlsx";
		
		retorno.setHeader(headerKey, headerValue);
		List<Parecer> listaPareceres = repository.findAll();
		ExportarExcel e = new ExportarExcel(listaPareceres);
		e.Exportar(retorno);
	}
```