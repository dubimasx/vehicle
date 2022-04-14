package com.solvd.interfaces;
@FunctionalInterface
public interface ILoad<B, P> {
     B add(B b, P p);
}
