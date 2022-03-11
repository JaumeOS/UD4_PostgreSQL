package dades;

import java.util.Arrays;

public class Matricula {
  private Alumne alumne;
  private Assignatura assignatura;
  private Integer[] notes;

  public Matricula() {
  }

  public Matricula(Alumne alumne, Assignatura assignatura, Integer[] notes) {
    this.setAlumne(alumne);
    this.setAssignatura(assignatura);
    this.setNotes(notes);
  }


  public Alumne getAlumne() {
    return alumne;
  }

  public void setAlumne(Alumne alumne) {
    this.alumne = alumne;
  }

  public Assignatura getAssignatura() {
    return assignatura;
  }

  public void setAssignatura(Assignatura assignatura) {
    this.assignatura = assignatura;
  }

  public Integer[] getNotes() {
    return notes;
  }

  public void setNotes(Integer[] notes) {
    this.notes = notes;
  }

  @Override
  public String toString() {
    return "Matricula{" +
        "alumne=" + alumne +
        ", assignatura=" + assignatura +
        ", notes=" + Arrays.toString(notes) +
        '}';
  }
}