package org.example.ServerMoudle.commands;

import org.example.Exeption.WrongAmountOfElementsException;
import org.example.ServerMoudle.File.Collection;
import org.example.model.Worker;

/**
 * The class is used to update the value of the collection element whose id is equal to the given one
 */
public class UpdateId extends Command {
    private Collection collection;

    public UpdateId(Collection collection) {
        this.collection = collection;
    }
/**
 * The function takes an argument, which is the id of the organization that will be updated.
 * @params argument The argument that the user entered.
 */
    @Override
    public void execute(String[] args) {
        if (args.length == 1){
            int id = Integer.parseInt(args[0]);
        Worker worker =collection.getById(id);
        if (worker != null){
            Worker newWorker = WorkerBuilder.create(id); //проверить
            collection.update(id, newWorker);
            ManagerResult.write("операция успешно выполнена");
        }
    } else{
            throw new WrongAmountOfElementsException();
        }
    }
}
