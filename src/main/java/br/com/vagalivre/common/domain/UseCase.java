package br.com.vagalivre.common.domain;

public interface UseCase<TReturn, TParams> {
    TReturn execute(TParams params);
}
