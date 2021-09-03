package programmers.weekchallenge;

import java.util.*;

public class RecommendJob {
    public static void main(String[] args){
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages = {"PYTHON", "C++", "SQL"};
        int[] preference = {7, 5, 5};

        System.out.println(new RecommendJob().solution(table, languages, preference));
    }

    private class Job implements Comparable<Job>{
        String jobName;
        int score;
        Job(String jobName, int score){
            this.jobName = jobName;
            this.score = score;
        }

        @Override
        public int compareTo(Job o) {
            if(this.score - o.score > 0){
                return -1;
            }else if(this.score - o.score < 0){
                return 1;
            }else{
                return this.jobName.compareTo(o.jobName);
            }
        }
    }

    public String solution(String[] table, String[] languages, int[] preference){
        Map<String, Integer> languagesPreference = new HashMap<>();
        for(int i = 0; i < languages.length; i++){
            languagesPreference.put(languages[i], preference[i]);
        }

        List<Job> jobScores = new ArrayList<>();
        String[] rowContents;
        int score;
        for(String row : table){
            rowContents = row.split(" ");
            score=0;

            for(int i = 1; i < rowContents.length; i++){
                if(languagesPreference.get(rowContents[i]) != null){
                    score += (6-i) * languagesPreference.get(rowContents[i]);
                }
            }
            jobScores.add(new Job(rowContents[0], score));
        }

        Collections.sort(jobScores);
        return jobScores.get(0).jobName;
    }
}
