package com.jarvis.amlich.presentation.ui.calendar.notify

import androidx.lifecycle.MutableLiveData
import com.jarvis.amlich.domain.model.NoteModel
import com.jarvis.amlich.domain.usecase.note.InsertNoteUseCase
import com.jarvis.amlich.presentation.ui.calendar.CalendarViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

class NoteViewModel : CalendarViewModel() {
    private val insertNoteUseCase: InsertNoteUseCase by inject()
    val isInsertNoteSuccess = MutableLiveData<Boolean>()
    fun insertNote(note: NoteModel) {
        executeTask(onExecute = {
            mLoading.value = true
            withContext(Dispatchers.IO) {
                insertNoteUseCase.invoke(note)
            }
            isInsertNoteSuccess.postValue(true)
            mLoading.value = false
        })
    }
}
