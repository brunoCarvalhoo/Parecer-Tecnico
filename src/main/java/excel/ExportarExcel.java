package excel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.org.cesar.entities.Parecer;

public class ExportarExcel {

	private XSSFWorkbook pastaDeTrabalho;
	private XSSFSheet tabela;
	
	private List<Parecer> listaPareceres;
	
	public ExportarExcel(List<Parecer> listaPareceres) {
		this.listaPareceres = listaPareceres;
		pastaDeTrabalho = new XSSFWorkbook();
	}
	private void CriarCelula (Row linha,int contadorColunas, Object valor, CellStyle tipo) {
		tabela.autoSizeColumn(contadorColunas);
		Cell celula = linha.createCell(contadorColunas);
		celula.setCellStyle(tipo);
	}
	private void EscreverTitulo() {
		tabela = pastaDeTrabalho.createSheet("Relatorio");
		
		Row linha = tabela.createRow(0);
		CellStyle tipo = pastaDeTrabalho.createCellStyle();
		XSSFFont fonte = pastaDeTrabalho.createFont();
		
		fonte.setBold(true);
		fonte.setFontHeight(24);
		tipo.setFont(fonte);
		tipo.setAlignment(HorizontalAlignment.CENTER);
		CriarCelula(linha,0,"Informações",tipo);
		tabela.addMergedRegion(new CellRangeAddress(0,0,0,6));
		fonte.setFontHeightInPoints((short)(10));
		
		linha = tabela.createRow(1);
		fonte.setBold(true);
		fonte.setFontHeight(20);
		tipo.setFont(fonte);
		CriarCelula(linha,1,"Identificador",tipo); //A1
		CriarCelula(linha,2,"Técnico",tipo); //A2
		CriarCelula(linha,3,"Cliente",tipo); //A3
		CriarCelula(linha,4,"Aparelho",tipo); //A4
		CriarCelula(linha,5,"Defeito",tipo); //A5
		CriarCelula(linha,6,"Parecer",tipo); //A6
	}
	private void PreencherInformações() {
		int contadorLinhas = 2;
		
		CellStyle tipo = pastaDeTrabalho.createCellStyle();
		XSSFFont fonte = pastaDeTrabalho.createFont();
		fonte.setFontHeight(16);
		tipo.setFont(fonte);
		
		for(Parecer parecer:listaPareceres) {
			Row linha = tabela.createRow(contadorLinhas);
			int contadorColuna = 0;
			CriarCelula(linha, contadorColuna++, parecer.getId(),tipo);
			CriarCelula(linha, contadorColuna++, parecer.getCliente(),tipo);
			CriarCelula(linha, contadorColuna++, parecer.getTecnico(),tipo);
			CriarCelula(linha, contadorColuna++, parecer.getEquipamento(),tipo);
			CriarCelula(linha, contadorColuna++, parecer.getDefeito(),tipo);
			CriarCelula(linha, contadorColuna++, parecer.getParecer(),tipo);
		}
	}
	public void Exportar(HttpServletResponse retorno) throws IOException {
		EscreverTitulo();
		PreencherInformações();
		
		ServletOutputStream saida = retorno.getOutputStream();
		pastaDeTrabalho.write(saida);
		pastaDeTrabalho.close();
		saida.close();
		
	}
}
