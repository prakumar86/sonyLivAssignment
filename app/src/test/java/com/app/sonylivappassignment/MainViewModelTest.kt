package com.app.sonylivappassignment

import android.app.Application
import com.app.sonylivappassignment.service.usecase.MainUseCase
import com.app.sonylivappassignment.viewmodel.MainViewModel
import junit.framework.TestCase
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class MainViewModelTest : MainModuleTest() {
    @Mock
    private lateinit var mainUseCase: MainUseCase
    @Mock
    private lateinit var application: Application

    private lateinit var mainViewModel: MainViewModel

    override fun setup() {
        super.setup()
        mainViewModel = MainViewModel()
    }

    override fun testDependencyBindings() {
        TestCase.assertNotNull(MainUseCase.getInstance())
    }


    @Test
    fun test_refreshInformationCardsOnEmptyBannerListTest() {
        Mockito.`when`(mainUseCase.getProjectList()).thenCallRealMethod()
        mainUseCase.getProjectList()
        Mockito.verify(mainUseCase, Mockito.atLeast(1))
            .getProjectList()
    }
}
