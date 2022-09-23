<!DOCTYPE html>

<html>
    <head>
        <title>Calculate</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
            <form action="calculator" method="post">
                First: <input type="number" name="first" value = ${first}><br>
                Second: <input type="number" name="second" value = ${second}><br>
                <select name="operator">
                    <option value="plus" ${operator== "plus" ? "selected" : ""}>+</option>
                    <option value="minus"${operator== "minus" ? "selected" : ""}>-</option>
                    <option value="mul" ${operator== "mul" ? "selected" : ""}>/</option>
                    <option value="div" ${operator== "div" ? "selected" : ""}>*</option>
                </select><br>
                <input type="submit" value="Compute"><br>
                Result: <input  name="result" value=${result}>

            </form>
        </div>
    </body>
</html>
