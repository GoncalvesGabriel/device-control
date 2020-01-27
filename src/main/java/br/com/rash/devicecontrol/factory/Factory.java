package br.com.rash.devicecontrol.factory;


public interface Factory<R, T> {

   T findOrCreate(R representation);

}
