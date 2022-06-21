//uno studente ha nome Ciccio (String)
//uno skill level (int) che parte da zero
//un metodo "studia" che stampa "sto studiando" ed incrementa skill level +1
//metodo "showSkillLevel" che stampa lo skill level

package humanResources;

public class Student {
	public String name = "Ciccio";
	public int skillLevel; //inizializzato a 0 di default
	public void showSkillLevel() {
		System.out.println(skillLevel);
	}
	public void study() {
		System.out.println("Sto studiando Java");
		//skillLevel = skillLevel +1;
		skillLevel++;
		//++skillLevel;
	}
}

