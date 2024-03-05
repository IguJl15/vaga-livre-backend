package br.com.vagalivre.common.domain;

public interface InputUseCase <TInput>{
    void call(TInput input);
}
