package com.maxwell;

import org.junit.Test;

import java.util.*;

/**
 * USER:Maxwell
 * DATE:16/7/2
 */
public class SnakeUtilTest {

    @Test
    public void test1() throws Exception {
        SnakeUtil snakeUtil = new SnakeUtil();
        List<Integer> teams = snakeUtil.createTeams(15);
        printLists(teams);
    }

    @Test
    public void test2() throws Exception {
        SnakeUtil snakeUtil = new SnakeUtil();
        printSchedule(snakeUtil.createTeams(15));

    }

    private void printLists(List<Integer> teams) {
        LinkedList<Integer> leftTeams = new LinkedList<>(teams.subList(0, teams.size() / 2));
        LinkedList<Integer> rightTeams = new LinkedList<>(teams.subList(teams.size() / 2, teams.size()));
        rightTeams.sort(Comparator.comparing(Integer::intValue).reversed());
        SnakeUtil snakeUtil = new SnakeUtil();
        for (int i = 1; i < teams.size(); i++) {
            for (int j = 0; j < leftTeams.size(); j++) {
                Integer right = rightTeams.get(j);
                Integer left = leftTeams.get(j);
                System.out.println((left == 0 ? "轮空" : left) + "-" + (right == 0 ? "轮空" : right));
            }
            System.out.println("----");
            snakeUtil.moveListElement(leftTeams, rightTeams);
        }
    }

    private void printSchedule(List<Integer> teams) {
        SnakeUtil snakeUtil = new SnakeUtil();
        LinkedList<Integer> leftTeams = new LinkedList<>(teams.subList(0, teams.size() / 2));
        LinkedList<Integer> rightTeams = new LinkedList<>(teams.subList(teams.size() / 2, teams.size()));
        Collections.reverse(rightTeams);
        System.out.printf(String.format("%3.8s", ""));
        Map<Integer, List<String>> teamMap = initMap(teams.size());
        for (int i = 1; i < teams.size(); i++) {
            for (int j = 0; j < leftTeams.size(); j++) {
                Integer right = rightTeams.get(j);
                Integer left = leftTeams.get(j);
                if (right != 0)
                    teamMap.get(right).add(left == 0 ? "空" : left.toString());
                if (left != 0)
                    teamMap.get(left).add(right == 0 ? "空" : right.toString());
            }
            snakeUtil.moveListElement(leftTeams, rightTeams);
        }
        System.out.println();
        for (Integer team : teams) {
            if (team == 0) continue;
            System.out.print(String.format("%6s", team));
            for (String i : teamMap.get(team)) {
                System.out.printf("%6s", i);
            }
            System.out.println();
        }
    }

    private Map<Integer, List<String>> initMap(int size) {
        Map<Integer, List<String>> teamMap = new HashMap<>();
        size = size % 2 == 0 ? size : size - 1;
        for (int i = 0; i < size; i++) {
            teamMap.put(i + 1, new ArrayList<>());
        }
        return teamMap;
    }

}