/**
package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Student> students) {
        double average = 0;
        int subjCount = 0;
        for (Student student : students) {
            for (Subject subject : student.subjects()) {
                average += subject.score();
                subjCount++;
            }
        }
        average /= subjCount;
        return average;
    }

    public static List<Label> averageScoreByPupil(List<Student> students) {
        List<Label> labels = new ArrayList<>();
        for (Student student : students) {
            int average = 0;
            List<Subject> subjects = student.subjects();
            for (Subject subj : subjects) {
                average += subj.score();
            }
            average /= subjects.size();
            labels.add(new Label(student.name(), average));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Student> students) {
        Map<String, Integer> labels = new LinkedHashMap<>();
            for (Student student : students) {
                for (Subject pupilSubj : student.subjects()) {
                    if (labels.containsKey(pupilSubj.name())) {
                        int sum = labels.get(pupilSubj.name()) + pupilSubj.score();
                        labels.put(pupilSubj.name(), sum);
                    } else {
                        labels.put(pupilSubj.name(), pupilSubj.score());
                    }
                }
            }

            List<Label> labelList = new ArrayList<>();
            for (String key : labels.keySet()) {
                labelList.add(new Label(key, labels.get(key) / students.size()));
            }
        return labelList;
    }

    public static Label bestStudent(List<Student> students) {
        List<Label> labels = new ArrayList<>();
        for (Student student : students) {
            int average = 0;
            List<Subject> subjects = student.subjects();
            for (Subject subj : subjects) {
                average += subj.score();
            }
            labels.add(new Label(student.name(), average));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Student> students) {
        Map<String, Integer> labels = new LinkedHashMap<>();
        for (Student student : students) {
            for (Subject pupilSubj : student.subjects()) {
                if (labels.containsKey(pupilSubj.name())) {
                    int sum = labels.get(pupilSubj.name()) + pupilSubj.score();
                    labels.put(pupilSubj.name(), sum);
                } else {
                    labels.put(pupilSubj.name(), pupilSubj.score());
                }
            }
        }

        List<Label> labelList = new ArrayList<>();
        for (String key : labels.keySet()) {
            labelList.add(new Label(key, labels.get(key)));
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }
}
 */