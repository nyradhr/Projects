/* 
classe Corso: stringa titolo, intero durata
dentro package school.learningMaterial

classe Instructor: stringa nome, corso assignedCourse
nel package school.hr
ha un corso JavaForDummies di durata 200h
metodo showCourse stampa titolo corso insegnato dal professore

classe Program: main che crea professore e stampa titolo corso
nel package school
*/


package school;
import school.hr.*;
import school.learningMaterial.*;

public class Program {
	public static void main (String[] args) {
		Instructor professor = new Instructor();
		professor.showCourse();
	}
}