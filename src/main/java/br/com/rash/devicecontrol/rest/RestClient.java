package br.com.rash.devicecontrol.rest;

public interface RestClient<T> {

  public T getRepresentation(T incompleteRepresentatio);

}
