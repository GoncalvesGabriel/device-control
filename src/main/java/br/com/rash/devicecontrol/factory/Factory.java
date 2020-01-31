package br.com.rash.devicecontrol.factory;


public interface Factory<R, T> {

   T create(R representation);

}
