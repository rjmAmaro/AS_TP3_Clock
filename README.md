### Arquitectura de Software
2016

## TP3 - Clock

## Distribuição de Trabalho
* Amaro - Timeouts
* Cerveira - Alarmes
* Telmo - Relógio

Tenham em atenção a parte do State. Cada uma das secções deve ficar de acordo com o Design Pattern do State. Tentem integrar isso na vossa parte.

Aqui têm um link para a implementação da ficha do State que o prof deu na outra aula:
https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/state/gumballstate

Se quiserem perceber como tenho feito, dêem uma vista de olhos no branch 'timeout', onde já implementei uma parte relacionada com o State.


## Estrutura

### Classes base do programa 
#### **Application**
Nesta classe temos uma inatância AppFrame, que vai conter 3 containers:
* Container do relógio: **ClockPanel**
* Container dos alarmes: **AlarmPanel**
* Container do timeout: **TimeoutPanel**

Na classe Application serão também declarados todos os Observers para que estes possam ser ligados ao Observable (instância da classe ClockDriver)

É a classe Application que inicia todo o projecto.



#### ClockDriver
Responsável por contar o tempo, e que vai notificar todos os _Observers_ sempre que passa um segundo no tempo

Em cada um dos containers vai existir uma referência para a instância desta classe.

### Classes Panel
Cada classe Panel - ClockPanel, AlarmPanel, e TimeoutPanel - serve como secção na parte visual do projecto.
Em cada Panel existe o método _**build**_ que recebe referências para os objectos necessários para se passar informação de um lado para o outro.

