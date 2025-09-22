# Exercícios – Capítulo 9: Subprogramas

## Exercício 1 – Passagem de Parâmetros por Valor e por Referência
Considere o seguinte pseudocódigo de uma função que tenta dobrar o valor de um número:

```text
procedure dobrar(x)
    x := x * 2
end
```

1. Implemente esse subprograma em **C** duas vezes:
   - A primeira versão recebendo o parâmetro **por valor**.

   #include <stdio.h>

// função que recebe por valor
void dobrarValor(int x) {
    x = x * 2;
    printf("Dentro da função (por valor): %d\n", x);
}

   - A segunda versão recebendo o parâmetro **por referência** (usando ponteiros).

   // função que recebe por referência
void dobrarReferencia(int *x) {
    *x = (*x) * 2;
    printf("Dentro da função (por referência): %d\n", *x);
}
**_______________________________________________________________________________**

2. Escreva um programa principal que:
   - Crie uma variável inteira com valor inicial 10.
   - Chame a função `dobrar` por valor e exiba o resultado.
   - Chame a função `dobrar` por referência e exiba o resultado.

int main() {
    int num = 10;

    printf("Valor inicial: %d\n", num);

    dobrarValor(num);
    printf("Após chamada por valor: %d\n", num);

    dobrarReferencia(&num);
    printf("Após chamada por referência: %d\n", num);

    return 0;
}


**Questões:**
- Qual a diferença observada entre as duas versões?

**Resposta**
Na versão por valor, a variável num não se altera no programa principal (só dentro da função).
Na versão por referência, num é alterado no programa principal, porque a função recebe o endereço da variável.

- Por que o valor da variável só se altera na versão por referência?

**Resposta**
Porque, ao passar por valor, a função trabalha com uma cópia da variável.
Ao passar por referência, a função manipula diretamente a memória da variável original.

- Relacione essa diferença com as estratégias de passagem de parâmetros discutidas no Capítulo 9.

**Resposta**
Por valor: proteção da variável original, mas não altera seu valor fora da função.

Por referência: maior eficiência (não faz cópia) e permite modificar diretamente a variável original, mas pode causar efeitos colaterais.
**_______________________________________________________________________________**
---

## Exercício 2 – Corrotinas em GoLang (primeiro contato)
As **corrotinas** permitem a execução concorrente de rotinas dentro de um programa. Em Go, isso é feito com a palavra-chave `go`.

1. Crie um arquivo chamado `main.go`.
2. Implemente o seguinte programa simples:

```go
package main

import (
    "fmt"
    "time"
)

func escrever(texto string) {
    for i := 0; i < 5; i++ {
        fmt.Println(texto, i)
        time.Sleep(time.Millisecond * 500)
    }
}

func main() {
    go escrever("Corrotina")  // executa em paralelo
    escrever("Função normal") // executa no fluxo principal
}
```

3. Compile e execute o programa com:
   ```bash
   go run main.go
   ```

**Questões:**
- O que acontece com a ordem das mensagens exibidas?
**Resposta**
As mensagens da função normal e da corrotina aparecem intercaladas e a ordem pode variar a cada execução.

- Por que as mensagens da corrotina e da função normal se intercalam?
**Resposta**
Porque a corrotina é executada em paralelo ao fluxo principal, de forma concorrente. O escalonador do Go distribui o tempo de CPU entre elas.

- Relacione esse comportamento com a definição de **corrotinas** estudada no Capítulo 9.
**Resposta**
As corrotinas permitem que diferentes partes do programa sejam executadas de forma concorrente, sem precisar criar threads manualmente. Isso se encaixa na definição de subprogramas concorrentes, que podem pausar e retomar execução cooperativamente.
