Author: Paul Lorenz

> module Main where
> import Workflow
> import Task
> import IO
> import Data.Char
> import System.Directory
> import WorkflowXml
> import TaskXml

> handleTask :: Task -> WfInstance [Task] -> IO (WfInstance [Task])
> handleTask task wf =
>     do putStrLn $ "Task name: " ++ (getName task)
>        putStrLn $ "Task desc: " ++ (getDesc task)
>        putStrLn $ "Task state: " ++ show (getState task)
>        case (getState task) of
>            Open -> do putStr "Would you like to complete this task (Y/N): "
>                       response <- getLine
>                       case (map (toUpper) response) of
>                           "Y" -> do newWf <- completeTask task wf
>                                     putStrLn "Task Completed"
>                                     return newWf
>                           otherwise -> do putStrLn "Suit yourself."
>                                           return wf
>            Complete -> do return wf

> getTask _ [] = Left "Invalid task number"
> getTask taskNumber tasks@(first:rest)
>     | taskNumber < 1  = Left "Invalid task number"
>     | taskNumber == 1 = Right first
>     | otherwise       = getTask (taskNumber - 1) rest

> showTokens []     = do return ()
> showTokens (x:xs) = do putStrLn (show x)
>                        showTokens xs

> processTasks wf@(WfInstance graph []        tasks) = do putStrLn "Workflow complete!"
> processTasks wf@(WfInstance graph tokenList tasks) =
>     do putStrLn ""
>        showTaskList tasks
>        putStr "> "
>        cmd <- getLine
>        case (getCmdType cmd) of
>            ShowTokenCmd -> do showTokens tokenList
>                               processTasks wf
>            TaskCmd ->
>                case (getTask ((read cmd)::Integer) tasks) of
>                    Left msg -> do putStrLn msg
>                                   processTasks wf
>                    Right task -> do newWf <- handleTask task wf
>                                     processTasks newWf
>            BadCmd -> do putStrLn $ cmd ++ " is not a valid command or task entry"
>                         processTasks wf

> data CmdType = ShowTokenCmd | TaskCmd | BadCmd

> getCmdType input
>     | (map (toUpper) input) == "T" = ShowTokenCmd
>     | all (isDigit) input          = TaskCmd
>     | otherwise                    = BadCmd

> main =
>     do hSetBuffering stdout NoBuffering
>        wfList <- getWorkflowList
>        selectWorkflow wfList

> selectWorkflow wfList =
>     do putStrLn "\n-=Available workflows=-"
>        showWorkflows wfList 1
>        putStr "\nSelect workflow: "
>        wf <- getLine
>        if ((not $ null wf) && all (isDigit) wf)
>          then useWorkflow wfList (((read wf)::Int) - 1)
>          else do putStrLn $ "ERROR: " ++ wf ++ " is not a valid workflow"
>        selectWorkflow wfList

> useWorkflow wfList idx
>     | length wfList <= idx = do putStrLn "ERROR: Invalid workflow number"
>     | otherwise            = do result <- loadWfGraphFromFile (wfList !! idx) elemFunctionMap
>                                 case (result) of
>                                     Left msg -> putStrLn $ "ERROR: Could not load workflow: " ++ msg
>                                     Right wfGraph -> do putStrLn "Running workflow"
>                                                         -- putStrLn (show wfGraph)
>                                                         runWorkflow wfGraph
>    where
>        elemFunctionMap = elemMapWith [ ("task", processTaskElement) ]

> runWorkflow wfGraph =
>     case (startWorkflow wfGraph []) of
>            Left msg -> putStrLn msg
>            Right wfInstanceIO -> do wf <- wfInstanceIO
>                                     processTasks wf

> showWorkflows [] _ = do return ()
> showWorkflows (wf:rest) counter =
>  do putStrLn $ "  " ++ (show counter) ++ ": " ++ wf
>     showWorkflows rest (counter + 1)

> getWorkflowList =
>     do fileList <- getDirectoryContents wfDir
>        return $ (useFullPath.filterWfs) fileList
>   where
>     wfDir = "/home/paul/workspace/functional-workflow/test-wf/"
>     filterWfs = (filter (hasExtension ".wf.xml"))
>     useFullPath = (map (\f->wfDir ++ f))

> hasExtension ext name = all (\(x,y) -> x == y) $ zip (reverse ext) (reverse name)