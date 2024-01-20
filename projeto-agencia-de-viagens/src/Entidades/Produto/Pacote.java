package Entidades.Produto;

import Repositorios.AeroportosRepositorio;
import Entidades.Aeroporto;
import Entidades.Cidade;

import Entidades.Trecho;
import java.util.ArrayList;

public class Pacote {
    
    private int nroPessoas;
    private ArrayList<Passagem> passagens;
    private Hospedagem hospedagens;
    private ArrayList<Atracao> atracoes;
    
    public int getNumPessoas(){
        return nroPessoas;
    }
    
    public ArrayList<Trecho> getTrechos(Cidade cidadeOrigem, Cidade cidadeDestino, String data, int nroPessoas){
        this.nroPessoas =  nroPessoas;
        
        ArrayList<Trecho> trechosDisponiveis = new ArrayList<>();
        
        AeroportosRepositorio aeroportosRepo = new AeroportosRepositorio();
        ArrayList<Aeroporto> aeroportosOrigem = aeroportosRepo.getAeroportosDaCidade(cidadeOrigem);
        ArrayList<Aeroporto> aeroportosDestino = aeroportosRepo.getAeroportosDaCidade(cidadeDestino);
        
        Trecho t = new Trecho(cidadeOrigem, cidadeDestino, aeroportosOrigem.get(0), aeroportosDestino.get(0), data, "09:00");
        Trecho t2 = new Trecho(cidadeOrigem, cidadeDestino, aeroportosOrigem.get(0), aeroportosDestino.get(0), data, "12:00");
        
        trechosDisponiveis.add(t);
        trechosDisponiveis.add(t2);
        
        return trechosDisponiveis;
    }
 
    public Hospedagem getHospedagens(){
        return hospedagens;
    }
    
    public ArrayList<Atracao> getAtracoes(){
        return atracoes;
    }
    
    public ArrayList<Passagem> getPassagens(){
        return passagens;
    }
    
    public void setPassagens(ArrayList<Passagem> passagens){
        this.passagens = passagens;
    }
    
    public void setHospedagem(Hospedagem hospedagem){
        this.hospedagens = hospedagem;
    }
    
    public void setAtracao(ArrayList<Atracao> atracoes){
        this.atracoes = atracoes;
    }
    
    
    public void emitePacoteCompleto(){
        System.out.println("PASSAGEM: ");
        for (Passagem passagem : passagens) {
            System.out.println(passagem.emitePassagem());
        }
        
        System.out.println("HOSPEDAGEM:\n");
        System.out.println(hospedagens.toString());
        
        System.out.println("\nATRACOES INCLUSAS:\n");
        for (Atracao atracao: atracoes) {
            System.out.println(atracao.getNome());
        }
    }
    
    public void emitePassagens(){
        for (Passagem passagen : passagens) {
            System.out.println(passagen.emitePassagem());
        }
    }
}
