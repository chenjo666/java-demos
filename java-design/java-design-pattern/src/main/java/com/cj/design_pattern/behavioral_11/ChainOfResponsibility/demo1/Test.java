package com.cj.design_pattern.behavioral_11.ChainOfResponsibility.demo1;
enum ProblemType {
    JUNIOR("junior"),
    INTERMEDIATE("intermediate"),
    SENIOR("senior"),
    OTHER("other");
    private final String value;
    private ProblemType(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
class Problem {
    private final ProblemType type;

    public Problem(ProblemType type) {
        this.type = type;
    }

    public ProblemType getType() {
        return type;
    }
}

abstract class Engineer {
    private Engineer next;
    public Engineer setNext(Engineer engineer) {
        next = engineer;
        return next;
    }

    public Engineer getNext() {
        return next;
    }

    public abstract void resolveProblem(Problem problem);
}

class JuniorEngineer extends Engineer {
    @Override
    public void resolveProblem(Problem problem) {
        if (problem.getType() == ProblemType.JUNIOR) {
            System.out.println("当前问题被初级工程师解决！");
        } else if (getNext() != null) {
            getNext().resolveProblem(problem);
        }
    }
}

class IntermediateEngineer extends Engineer {
    @Override
    public void resolveProblem(Problem problem) {
        if (problem.getType() == ProblemType.INTERMEDIATE) {
            System.out.println("当前问题被中级工程师解决！");
        } else if (getNext() != null) {
            getNext().resolveProblem(problem);
        }
    }
}

class SeniorEngineer extends Engineer {
    @Override
    public void resolveProblem(Problem problem) {
        if (problem.getType() == ProblemType.SENIOR) {
            System.out.println("当前问题被高级工程师解决！");
        } else if (getNext() != null) {
            getNext().resolveProblem(problem);
        }
    }
}

class Architect extends Engineer {
    @Override
    public void resolveProblem(Problem problem) {
        if (problem.getType() == ProblemType.OTHER) {
            System.out.println("当前问题被架构师解决！");
        } else if (getNext() != null) {
            getNext().resolveProblem(problem);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Engineer juniorEngineer = new JuniorEngineer();
        Engineer intermediateEngineer = new IntermediateEngineer();
        Engineer seniorEngineer = new SeniorEngineer();
        Engineer architect = new Architect();
        // 构造职责链
        juniorEngineer.setNext(intermediateEngineer).setNext(seniorEngineer).setNext(architect);
        // 产生问题
        Problem juniorProblem = new Problem(ProblemType.JUNIOR);
        Problem intermediateProblem = new Problem(ProblemType.INTERMEDIATE);
        Problem seniorProblem = new Problem(ProblemType.SENIOR);
        Problem otherProblem = new Problem(ProblemType.OTHER);

        juniorEngineer.resolveProblem(juniorProblem);
        juniorEngineer.resolveProblem(intermediateProblem);
        juniorEngineer.resolveProblem(seniorProblem);
        juniorEngineer.resolveProblem(otherProblem);
    }
}
//当前问题被初级工程师解决！
//当前问题被中级工程师解决！
//当前问题被高级工程师解决！
//当前问题被架构师解决！