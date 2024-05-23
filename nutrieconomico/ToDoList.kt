package mx.paola.nutrieconomico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.paola.nutrieconomico.databinding.ActivityToDoListBinding

private lateinit var binding: ActivityToDoListBinding
private lateinit var rvTodos: RecyclerView
private lateinit var etTodo: EditText
private lateinit var btnAddTodo: Button


class ToDoList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToDoListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvTodos = binding.rvTodos
        etTodo = binding.etTodo
        btnAddTodo = binding.btnAddTodo



        var todoList = mutableListOf(
            Todo("Ir caminando a los lugares", false),
            Todo("Hacer ejercicio", false),
            Todo("Limpiar", false),
            Todo("Subir escaleras", false),
            Todo("Meditar", false)

        )
        val adapter = TodoAdapter(todoList)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val title = etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size -1)
            etTodo.text.clear()
        }
    }
}