### Arquitectura de Software
2016

## TP3 - Clock

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