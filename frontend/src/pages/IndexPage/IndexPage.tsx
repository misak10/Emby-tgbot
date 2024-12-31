import { useEffect, useState, type FC } from 'react'
import { Page } from '@/components/Page.tsx'
import TextSkeleton from './components/TextSkeleton'

export const IndexPage: FC = () => {
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    // 模拟数据加载
    setTimeout(() => {
      setLoading(false)
    }, 2000)
  }, [])

  return (
    <Page back={false}>
      <div className='flex flex-col gap-4 px-5 py-4'>
        <div role='alert' className='alert flex alert-info shadow-lg'>
          <svg
            xmlns='http://www.w3.org/2000/svg'
            fill='none'
            viewBox='0 0 24 24'
            className='h-6 w-6 shrink-0 stroke-current'
          >
            <path
              strokeLinecap='round'
              strokeLinejoin='round'
              strokeWidth='2'
              d='M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z'
            ></path>
          </svg>
          <span className='text-base font-mono text-center whitespace-normal'>
            New Bot of AuroraMedia.
          </span>
        </div>
        <div className='flex rounded-xl bg-indigo-600 text-primary-content'>
          <div className='stats bg-indigo-600 text-primary-content min-w-full'>
            <div className='stat'>
              <div className='stat-title dark:text-slate-300 text-slate-400'>账户状态</div>
              {loading ? (
                <div className='flex min-w-full'>
                  <div className='flex-1 py-4 animate-pulse'>
                    <div className='h-2 bg-slate-200 rounded'></div>
                  </div>
                </div>
              ) : (
                <div className='text-slate-50 stat-value text-3xl lg:text-4xl'>可用</div>
              )}
            </div>
            <div className='stat'>
              <div className='stat-title dark:text-slate-300 text-slate-400'>Emby状态</div>
              {loading ? (
                <div className='flex min-w-full'>
                  <div className='flex-1 py-4 animate-pulse'>
                    <div className='h-2 bg-slate-200 rounded'></div>
                  </div>
                </div>
              ) : (
                <div className='text-slate-50 stat-value text-3xl lg:text-4xl'>可用</div>
              )}
            </div>
          </div>
        </div>
        <div className='stats bg-gray-700 text-primary-content min-w-full'>
          <div className='stat'>
            <div className='stat-title dark:text-slate-300 text-slate-400'>Aurora 电池</div>
            {loading ? (
              <TextSkeleton />
            ) : (
              <>
                <div className=''>
                  <div className='stat-value text-slate-50'>888</div>
                </div>
                <div className='stat-actions'>
                  <div className='grid grid-flow-row-dense grid-cols-2'>
                    <label htmlFor='checkin' className='btn btn-sm btn-success mr-2'>
                      签到
                    </label>
                    <input id='checkin' className='modal-toggle' type='checkbox' />
                    <label htmlFor='checkin' className='modal modal-middle'>
                      <label className='modal-box relative' htmlFor=''>
                        <label
                          htmlFor='checkin'
                          className='btn btn-sm btn-circle absolute right-5 top-5'
                        >
                          ✕
                        </label>
                        <h3 className='font-bold text-lg dark:text-white text-black'>签到验证</h3>
                        <div className='mx-4 mt-4 mb-2'>
                          <div id='cf-turnstile'>
                            <div>
                              <input
                                type='hidden'
                                name='cf-turnstile-response'
                                id='cf-chl-widget-uufsf_response'
                              />
                            </div>
                          </div>
                        </div>
                      </label>
                    </label>
                    <button className='btn btn-sm btn-warning ml-2'>修改密码</button>
                  </div>
                </div>
              </>
            )}
          </div>
        </div>
        <div className='stats bg-gray-700 stats-vertical shadow'>
          <div className='stat'>
            <div className='stat-title dark:text-slate-300 text-slate-400'>账户信息</div>
            {loading ? (
              <TextSkeleton />
            ) : (
              <>
                <div className='mt-1 dark:text-slate-400 text-slate-100'>账户ID: 1234567889</div>
                <div className='dark:text-slate-400 text-slate-100'>账户密码: REFOqR8oE3DRO</div>
              </>
            )}
          </div>
          <div className='stat'>
            <div className='stat-title dark:text-slate-300 text-slate-400'>连接信息</div>
            {loading ? (
              <TextSkeleton />
            ) : (
              <>
                <div className='mt-1 dark:text-slate-400 text-slate-100'>
                  连接地址: https://emby.xxx.org
                </div>
                <div className='dark:text-slate-400 text-slate-100'>连接端口: 888</div>
              </>
            )}
          </div>
        </div>
        <div className='stat bg-gray-700 rounded-xl'>
          <div className='stat-figure text-secondary'>
            <svg
              xmlns='http://www.w3.org/2000/svg'
              fill='none'
              viewBox='0 0 24 24'
              className='inline-block h-8 w-8 stroke-current'
            >
              <path
                strokeLinecap='round'
                strokeLinejoin='round'
                strokeWidth='2'
                d='M13 10V3L4 14h7v7l9-11h-7z'
              ></path>
            </svg>
          </div>
          <div className='stat-title dark:text-slate-300 text-slate-400'>剩余可用时间</div>
          <div className='stat-value text-secondary mb-1.5'>
            {loading ? (
              <TextSkeleton />
            ) : (
              <span className='countdown font-mono text-3xl'>
                <span style={{ '--value': 10 }}></span>d
                <span style={{ '--value': 24 }}></span>h
                <span style={{ '--value': 11 }}></span>m
              </span>
            )}
          </div>
          <div className='stat-desc dark:text-gray-400 text-zinc-400'>请不要忘记签到哦！</div>
        </div>
        <div className='divider m-0 mx-4'></div>
        <p className='text-sm text-slate-400'>Copyright © 2025 AuroraMedia</p>
      </div>
    </Page>
  )
}
