package family_tree.service;


import family_tree.builder.HumanBuilder;
import family_tree.family_tree1.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private final FamilyTree familyTree;
    private final HumanBuilder humanBuilder;

    public Service () {
        familyTree = new FamilyTree();
        humanBuilder = new HumanBuilder();
    }


    public Human addHuman(String name, LocalDate dob, Gender gender) {
        Human human = humanBuilder.build(name, dob, gender);
        familyTree.addHuman(human);
        return human;
    }

    public void sortByName () {
        familyTree.sortByName();
    }

    public void sortByDateBirth() {
        familyTree.sortByDateBirth();
    }

    public String getHumanListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:\n");

        for (Human human : familyTree) {
            stringBuilder.append(human).append("\n");
        }

        return stringBuilder.toString();
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    public Human findHumanById(int searchId) {
        return familyTree.findHumanById(searchId);
    }

    public List<Human> findHumansByName(String searchInput) {
        return familyTree.findHumansByName(searchInput);
    }
}