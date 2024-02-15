package PiCodeChallenge;

import java.util.*;


public class LetterCover {

    static class Node implements Comparable<Node> {
        final char c;
        int occur;

        Node(char c, int occur) {
            this.c = c;
            this.occur = occur;
        }

        Node() {
            c = 'a';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return c == node.c;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + this.c;
            return result;
        }

        @Override
        public int compareTo(Node o) {
            if (this.c == o.c) {
                return 0;
            }
            int occurComparison = Integer.compare(o.occur, this.occur);
            if (occurComparison == 0) {
                return Character.compare(o.c, this.c);
            }

            return occurComparison;
        }

        public void setOccur(int occur) {
            this.occur = occur;
        }

        public char getC() {
            return c;
        }

        private void incrementOccur() {
            this.occur++;
        }

        public int getOccur() {
            return occur;
        }

    }

    static List<Node> letters1 = new ArrayList<>();
    static List<Node> letters2 = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solution("loops", "loops"));
    }

    public static int solution(String P, String Q) {
        // Implement your solution here
        int size = P.length();

        char[] pChar = P.toCharArray();
        char[] qChar = Q.toCharArray();


        for (int i = 0; i < size; i++) {
            Node t1 = new Node(pChar[i], 1);
            Node t2 = new Node(qChar[i], 1);
            if (letters1.contains(t1)) {
                for (Node existingNode : letters1) {
                    if (existingNode.equals(t1)) {
                        existingNode.incrementOccur();
                        break;
                    }
                }
            } else {
                letters1.add(t1);
            }

            if (letters2.contains(t2)) {
                for (Node existingNode : letters2) {
                    if (existingNode.equals(t2)) {
                        existingNode.incrementOccur();
                        break;
                    }
                }
            } else {
                letters2.add(t2);
            }
        }

        Collections.sort(letters1);
        Collections.sort(letters2);

        int minDistinctLetters = 0;
        for (int i = 0; i < letters1.size(); i++) {

            size -= letters1.get(i).getOccur();
            minDistinctLetters++;
            int l2index = letters2.indexOf(letters1.get(i));
            if (l2index < 0) {
                size -= letters2.get(i).getOccur();
                minDistinctLetters++;
            } else {
                size -= letters2.get(l2index).getOccur();
                letters2.get(l2index).setOccur(0);
            }


            if (size <= 0) {
                return minDistinctLetters;
            }
        }


//        Iterator<Node> it1 = letters1.iterator();
//        Iterator<Node> it2 = letters2.iterator();
//        Node n1 = new Node();
//        Node n2 = new Node();
//        while (size > 0 && it1.hasNext() && it2.hasNext()) {
//            n1 = it1.next();
//            n2 = it2.next();
//
//            size -= n1.occur;
//            minDistinctLetters++;
//            size -= n2.occur;
//            if (!n1.equals(n2)) {
//                minDistinctLetters++;
//            }
//        }
//
//        while (size > 0 && it1.hasNext()) {
//            size -= n1.occur;
//            minDistinctLetters++;
//        }
//
//        while (size > 0 && it2.hasNext()) {
//            size -= n2.occur;
//            minDistinctLetters++;
//        }

        return minDistinctLetters;
    }

    public static int solution2(String P, String Q) {
        Set<Character> distLettersP = new HashSet<>();
        Set<Character> distLettersQ = new HashSet<>();
        for (int i = 0; i < P.length(); i++) {
            distLettersP.add(P.charAt(i));
            distLettersQ.add(Q.charAt(i));

        }
        distLettersP.retainAll(distLettersQ);
        return distLettersP.size();
    }
}
