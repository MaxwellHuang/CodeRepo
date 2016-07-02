package com.maxwell;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * USER:Maxwell
 * DATE:16/7/2
 */
public class SnakeUtil {

    public List<Integer> createTeams(int teamSize) {
        List<Integer> teamList = new ArrayList<>(teamSize);
        if (teamSize % 2 != 0) {
            for (int i = 1; i <= teamSize; i++) {
                teamList.add(i);
            }
            teamList.add(0);
        } else {
            for (int i = 1; i <= teamSize; i++) {
                teamList.add(i);
            }
        }

        return teamList;
    }

    public void moveListElement(LinkedList<Integer> leftTeams, LinkedList<Integer> rightTeams) {
        Integer first = leftTeams.pollFirst();
        Integer left = leftTeams.pollFirst();
        Integer right = rightTeams.pollLast();
        rightTeams.addFirst(left);
        leftTeams.addFirst(first);
        leftTeams.addLast(right);
    }


}
