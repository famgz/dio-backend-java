package com.dio;

import java.time.LocalDate;

import com.dio.desafio.dominio.Bootcamp;
import com.dio.desafio.dominio.Curso;
import com.dio.desafio.dominio.Dev;
import com.dio.desafio.dominio.Mentoria;

public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("descricao curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JS");
        curso2.setDescricao("descricao curso JS");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descricao mentoria java");
        mentoria.setData(LocalDate.now());

        // System.out.println(curso1);
        // System.out.println(curso2);
        // System.out.println(mentoria);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descricao bootcamp java");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev dev1 = new Dev();
        dev1.setNome("Pedro");
        dev1.increverBootcamp(bootcamp);
        System.out.println("Conteudos incritos dev1: " + dev1.getConteudosInscritos());
        System.out.println("Conteudos concluidos dev1: " + dev1.getConteudosConcluidos());

        dev1.progredir();
        System.out.println("Conteudos incritos dev1: " + dev1.getConteudosInscritos());
        System.out.println("Conteudos concluidos dev1: " + dev1.getConteudosConcluidos());
        System.out.println("XP dev1: " + dev1.calcularTotalXp());

        System.out.println("--------------------------------");

        Dev dev2 = new Dev();
        dev2.setNome("Joao");
        dev2.increverBootcamp(bootcamp);
        System.out.println("Conteudos incritos dev2: " + dev2.getConteudosInscritos());
        System.out.println("Conteudos concluidos dev2: " + dev2.getConteudosConcluidos());

        dev2.progredir();
        dev2.progredir();
        dev2.progredir();
        dev2.progredir();
        System.out.println("Conteudos incritos dev2: " + dev2.getConteudosInscritos());
        System.out.println("Conteudos concluidos dev2: " + dev2.getConteudosConcluidos());
        System.out.println("XP dev2: " + dev2.calcularTotalXp());

    }
}