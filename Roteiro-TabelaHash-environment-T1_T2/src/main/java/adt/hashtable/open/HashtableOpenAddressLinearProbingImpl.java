package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size, HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if(isFull()){
			throw new HashtableOverflowException();
		}
		if(element != null){
			int probe = 0;
			int index = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
			while(this.table[index] != null && !(this.table[index] == super.deletedElement)){
				probe++;
				index = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
				COLLISIONS++;
			}
			this.table[index] = element;
			elements++;
		}
	}

	@Override
	public void remove(T element) {
		if(element != null && !isEmpty()){
			int index = indexOf(element);
			if(index != -1){
				this.table[index] = super.deletedElement;
				elements--;
			}
		}
	}

	@Override
	public T search(T element) {
		if(element != null && !isEmpty()){
			int probe = 0;
			int index = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
			while(!this.table[index].equals(element) || this.table[index] == super.deletedElement){
				probe++;
				index = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
				if(this.table[index] == null){
					return null;
				}
			}
		}
		return element;
	}

	@Override
	public int indexOf(T element) {
		if(element == null || isEmpty() || search(element) == null){
			return -1;
		}else{
			int probe = 0;
			int index = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
			while(!this.table[index].equals(element)){
				probe++;
				index = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
			}
			return index;
		}
	}
}
