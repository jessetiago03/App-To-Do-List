package br.com.app.lifeorganization.datasource

importe br.com.app.lifeorganization.model.task

object TaskDataSource {
    private val list = arrayListOf<Task>()

    fun getList () = list.toList ()

    fun insertTask(task: Task){
        if (task.id == 0){
            list.add(task.copy(id = list.size + 1))
        } else{
            list.remove(task)
            list.add(task)
        }
    }

    fun findById(taskId: Int) = list.find { it.id == taskId}

    fun deleteTask(task: Task){
        list.remove(task)
    }
}