package adt.heap;
import java.time.LocalDateTime;

public class QueueElement<T> implements Comparable<QueueElement<T>> {

	private T dado;
	private LocalDateTime tempo;
	
	public QueueElement(T dado){
		setData(dado);
		tempo = LocalDateTime.now();
		
	}
	
	// Getters n setters

	public T getData() {
		return dado;
	}

	public void setData(T data) {
		this.dado = data;
	}
	
	public LocalDateTime getTime(){
		return tempo;
	}
	
	public void setTime(LocalDateTime time){
		this.tempo = time;
	}
	
	public int compareTo(QueueElement<T> e1) {
		return -(getTime().compareTo(e1.getTime()));
	}
}