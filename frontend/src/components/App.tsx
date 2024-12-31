import { useLaunchParams, miniApp, useSignal, mainButton } from '@telegram-apps/sdk-react'
import { AppRoot } from '@telegram-apps/telegram-ui'
import { Navigate, Route, Routes, HashRouter } from 'react-router-dom'
import { routes } from '@/navigation/routes.tsx'
import { useEffect } from 'react'

export function App() {
  const lp = useLaunchParams()
  const isDark = useSignal(miniApp.isDark)

  // 开启主按钮，点击关闭当前 mini app
  useEffect(() => {
    mainButton.setParams({
      isEnabled: true,
      isVisible: true,
      text: '关闭面板',
    })
    mainButton.onClick(() => {
      miniApp.close()
    })
  }, [])

  return (
    <AppRoot
      className='h-screen'
      appearance={isDark ? 'dark' : 'light'}
      platform={['macos', 'ios'].includes(lp.platform) ? 'ios' : 'base'}
    >
      <HashRouter>
        <Routes>
          {routes.map((route) => (
            <Route key={route.path} {...route} />
          ))}
          <Route path='*' element={<Navigate to='/' />} />
        </Routes>
      </HashRouter>
    </AppRoot>
  )
}
